package org.task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBWrapper {

    private final String path;
    private final String user;
    private final String password;

    public DBWrapper(String path, String user, String password) {
        this.path = path;
        this.user = user;
        this.password = password;
    }


    public void createTable(){
        try(Connection connection = DriverManager.getConnection(path, user, password)){

            try(Statement statement = connection.createStatement()){
                String createTable = """
                        CREATE TABLE IF NOT EXISTS smarterCalculatorResults (
                            id INT auto_increment primary key,
                            operation_type VARCHAR(20) NOT NULL,
                            left_operand VARCHAR(254) NOT NULL,
                            right_operand VARCHAR(254) NOT NULL,
                            operation VARCHAR(2) NOT NULL,
                            operation_result VARCHAR(255) NOT NULL
                        );
                        """;

                statement.execute(createTable);
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void insertIntoDB(List<List<String>> operations){

        String insertOperationRecord = """
                    INSERT INTO smarterCalculatorResults(operation_type, left_operand, right_operand, operation, operation_result)
                      VALUES (?, ?, ?, ?, ?);
                    """;
        try(
                Connection connection = DriverManager.getConnection(path, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(insertOperationRecord)
        ){
            for(List<String>op : operations){
                for(int i=0;i<op.size();i++){
                    preparedStatement.setString(i+1, op.get(i));
                }
                preparedStatement.execute();
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public String[] printFromDB(){

        String selectSQL = """
                SELECT
                  id,
                  operation_type,
                  left_operand,
                  right_operand,
                  operation,
                  operation_result
                FROM smarterCalculatorResults;
                """;
        List<String>s = new ArrayList<>();

        try(
                Connection connection = DriverManager.getConnection(path, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
                ResultSet resultSet = preparedStatement.executeQuery(selectSQL)
        ){
            System.out.println("\nFrom database:\n");
            int id;
            String operationType;
            String leftOperand;
            String rightOperand;
            String operation;
            String result;
            while (resultSet.next()){
                id = resultSet.getInt("id");
                operationType = resultSet.getString("operation_type");
                leftOperand = resultSet.getString("left_operand");
                rightOperand = resultSet.getString("right_operand");
                operation = resultSet.getString("operation");
                result = resultSet.getString("operation_result");

                s.add(leftOperand);
                s.add(operation);
                s.add(rightOperand);
                System.out.println(id + " | " + operationType + " | " + leftOperand + " | " + rightOperand + " | " + operation + " | " + result);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        String[] args = new String[s.size()];
        args = s.toArray(args);
        return args;

    }

    public void deleteAfterType(String type){
        String deleteSQL = """
                DELETE FROM smarterCalculatorResults
                WHERE lower(operation_type) = lower(?);
                """;
        try(
                Connection connection = DriverManager.getConnection(path, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)
        ){
            preparedStatement.setString(1, type);
            preparedStatement.execute();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    private List<List<String>> getFromSelect(){
        String selectSQL = """
                SELECT *
                FROM smarterCalculatorResults;
                """;

        List<List<String>>records = new ArrayList<>();

        try(
                Connection connection = DriverManager.getConnection(path, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
                ResultSet resultSet = preparedStatement.executeQuery(selectSQL)
        ){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String operationType = resultSet.getString("operation_type");
                String leftOperand = resultSet.getString("left_operand");
                String rightOperand = resultSet.getString("right_operand");
                String operation = resultSet.getString("operation");
                String result = resultSet.getString("operation_result");

                records.add(new ArrayList<>(){{
                    add(""+id);
                    add(operationType);
                    add(leftOperand);
                    add(rightOperand);
                    add(operation);
                    add(result);
                }});

            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return records;
    }

    public void deleteDuplicates(){

        String deleteSQL = """
                DELETE FROM smarterCalculatorResults
                WHERE id <> ?
                  AND operation_type = ?
                  AND left_operand = ?
                  AND right_operand = ?
                  AND operation = ?
                  AND operation_result = ?
                ;
                """;


        List<List<String>> records = getFromSelect();
        int oldSize = 0;
        int newSize = records.size();

        try(
                Connection connection = DriverManager.getConnection(path, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)
        ){
            int index = 0;
            while(index < records.size()){
                List<String> record = records.get(index++);
                for(int i=0; i<record.size();i++){
                    preparedStatement.setString(i+1, record.get(i));
                }
                preparedStatement.execute();
                records = getFromSelect();
            }
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }
}

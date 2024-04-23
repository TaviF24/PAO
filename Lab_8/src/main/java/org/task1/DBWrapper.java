package org.task1;

import java.sql.*;
import java.util.List;

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

    public void printFromDB(){

        String selectSQL = """
                SELECT * FROM smarterCalculatorResults;
                """;

        try(
                Connection connection = DriverManager.getConnection(path, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
                ResultSet resultSet = preparedStatement.executeQuery(selectSQL)
        ){
            System.out.println("\nSELECT * FROM smarterCalculatorResults;");
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

                if(operationType == null)
                    continue;
                System.out.println(id + " | " + operationType + " | " + leftOperand + " | " + rightOperand + " | " + operation + " | " + result);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }



    }
}

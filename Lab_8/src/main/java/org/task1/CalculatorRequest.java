package org.task1;

public record CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {

    private enum Types {
        Boolean,
        Integer,
        Double,
        Invalid
    }

    public Object getLeftOperand() {
        return leftOperand;
    }

    public Object getRightOperand() {
        return rightOperand;
    }

    public String getOperation() {
        return operation;
    }


    public String getRequestType() {
        Types res;
        switch (leftOperand.getClass().getSimpleName()) {
            case "Boolean":
                res = Types.Boolean;
                break;
            case "Double":
                res = Types.Double;
                break;
            case "Integer":
                res = Types.Integer;
                break;
            default:
                return Types.Invalid.toString();
        }
        switch (rightOperand.getClass().getSimpleName()) {
            case "Boolean":
                if (res == Types.Boolean)
                    return res.toString();
                return Types.Invalid.toString();
            case "Double":
                if (res == Types.Double || res == Types.Integer)
                    return Types.Double.toString();
                return Types.Invalid.toString();
            case "Integer":
                if (res == Types.Double || (operation.equals("/") && res == Types.Integer))
                    return Types.Double.toString();
                if (res == Types.Integer)
                    return Types.Integer.toString();
                return Types.Invalid.toString();
            default:
                return Types.Invalid.toString();
        }
    }

    @Override
    public String toString() {
        return leftOperand.toString() + " " + operation + " " + rightOperand.toString();
    }
}


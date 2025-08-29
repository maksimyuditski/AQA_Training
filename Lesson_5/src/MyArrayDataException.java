class MyArrayDataException extends Exception {
    private int row;
    private int column;

    public MyArrayDataException(String message, int row, int column) {
        super(message);
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " в ячейке [" + row + "][" + column + "]";
    }
}

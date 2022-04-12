import java.io.Serializable;

public class twoDimensionalMatrix implements Matrix, Serializable {
    private int[][] source;
    private int row;
    private int column;
    public twoDimensionalMatrix(int row,int column) {
        source=new int[row][column];    //初始化矩阵的行和列
        this.row=row;this.column=column;
    }

    /**
     *  初始化矩阵的各行各列的元素
     */
    public void initializetwoDimensionalMatrix(){
         for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
                source[i][j]=(int) (Math.random() * 20);
    }


    /**
     * @param b 判断二维数组是否可以相乘
     * @return
     */
    public  boolean judgeforMultiplying(twoDimensionalMatrix b) {
        if(this.source==null||b.source==null) return false;
        if (b.row <= 0 || this.row <= 0) return false;
        if (this.column != b.row) return false;  //当矩阵a的列数 不等于 b的行数
        else return true;                           //矩阵a的列数 等于 矩阵 b的行数
    }

    /**
     * @param b 将两个二维数组相乘
     * @return
     */
    public  twoDimensionalMatrix MultiplyTwoDimensionalMatrix(twoDimensionalMatrix b){
        if(!this.judgeforMultiplying(b)) return null;
        try {
            twoDimensionalMatrix c=new twoDimensionalMatrix(this.row,b.column);
                  //矩阵c的行数等于矩阵a的行数，矩阵c的列数等于矩阵b的列数
            for (int i = 0; i < this.row; i++) {   //确定 矩阵a的行数
                for (int k = 0; k < b.column; k++) {  //确定矩阵b的列数
                    int temp = 0;                      //c矩阵中的一个元素
                    for (int j = 0; j < this.source[i].length; j++)         //矩阵a和b  对应 的行列相乘的结果
                        temp += this.source[i][j] * b.source[j][k];
                    c.source[i][k] = temp;}
            }
            return c;}
        catch (Exception e)
        {e.printStackTrace();}
        return null;}


    /**
     * 将矩阵输出到String变量并返回
     * @return
     */
    public  String printMatrix(){
        String content="\n";
        String max=getMax(source);
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                 content+=String.format("%-"+max+"d",source[i][j]);
                       //20以内的数，格式化输出两位左对齐
                if(j!=column-1)
                    content+=" ";
                else
                    content+="\n";
                    }}
        content+="\n";
        return content;
    }

    /**
     * @param a 获取矩阵的元素的最大的那个，并返回其字符长度，
     *        用于在格式化输出的时候对齐位数
     * @return
     */
    public  String getMax(int[][] a){   //获取格式化字符串对齐时需要的位数
        int maxInt=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++)
                if(a[i][j]>maxInt) maxInt=a[i][j];
        }
        return Integer.toString(Integer.toString(maxInt).length());
    }
    
    
    public int[][] getSource() {
        return source;
    }

    public void setSource(int[][] source) {
        this.source = source;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

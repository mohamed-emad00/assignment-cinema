import java.util.Arrays;

public class CinemaArea {

    private byte noRows;
    private byte noColumns;
    private Character[][] area;
    private Integer noBooked;
    public static CinemaArea create(final byte noRows,final byte noColumns){
        if(noRows > 9 || noColumns > 9 ){
            IO.println("the area must be less than or equal 9 rows and 9 columns");
            return null;
        }
        return new CinemaArea( noRows,  noColumns );
    }


    private CinemaArea(byte noRows, byte noColumns ) {

        this.noRows = noRows;
        this.noColumns = noColumns;
        this.area = new Character[noRows][noColumns];
        for(Character [] row : area){
            Arrays.fill(row , 'O');
        }
        noBooked = 0;

    }
    public void printArea(){
        for(int i=0;i<noRows; i++){
            for(int j=0;j < noColumns; j++){
                IO.print("["+i+" "+j+"]"+ area[i][j]);
            }
            IO.println();
            for(int j=0; j<noColumns; j++){
                IO.print("-------");
            }
            IO.println();
        }
    }
    public Boolean book(String seatNumber){
        if(seatNumber.length() > 3){
            IO.println("the seat number to book not valid\nmust be between [0][0] to ["+noRows+"]" + "[" + noColumns + "]" );
            return false;
        }
        int rowNumber = seatNumber.charAt(0) - '0';
        int columnNumber = seatNumber.charAt(1) - '0';
        if(rowNumber + 1 > noRows || columnNumber + 1 > noColumns){
            IO.println("seat number is not valid\nmust be less than or equal "+ noRows + "rows " +noColumns +" columns");
            return false;
        }
        Character value = area[rowNumber][columnNumber];
        if(!value.equals('O')){
            IO.println("the seat [["+seatNumber+"]]is already booked: " + value);
            return false;
        }
        area[rowNumber][columnNumber] = 'X';
        noBooked++;
        return true;
    }
    public Boolean unbook(String seatNumber){
        if(seatNumber.length() > 3){
            IO.println("the seat number to book not valid\nmust be between [0][0] to ["+noRows+"]" + "[" + noColumns + "]" );
            return false;
        }
        int rowNumber = seatNumber.charAt(0) - '0';
        int columnNumber = seatNumber.charAt(1) - '0';
        if(rowNumber > noRows || columnNumber > noColumns){
            IO.println("seat number is not valid\nmust be less than or equal "+ noRows + "rows " +noColumns +" columns");
            return false;
        }
        Character value = area[rowNumber][columnNumber];
        if(!value.equals('X')){
            IO.println("the seat [["+seatNumber+"]]is already unbooked: " + value);
            return false;
        }
        area[rowNumber][columnNumber] = 'O';
        noBooked--;
        return true;
    }
    public void showSeatsStatus(){
        IO.println("no booked seats: " + noBooked);
        int totalSeats = noRows * noColumns;
        IO.println("no available seats: " + (totalSeats - noBooked));
        double occupancy = (double)noBooked / totalSeats;
        IO.println("the occupancy =" + occupancy * 100 + "%" );
        if(occupancy > 0.8 && occupancy < 1.0 ){
            IO.println("Almost Full");
        }
        // occupancy show %
    }
    // [00]O

    @Override
    public String toString() {
        return "CinemaArea{" +
                ", noRows=" + noRows +
                ", noColumns=" + noColumns +
                ", area=" + Arrays.toString(area) +
                ", noBooked=" + noBooked +
                '}';
    }
}

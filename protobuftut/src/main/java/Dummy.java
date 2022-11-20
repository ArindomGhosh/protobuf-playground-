import com.example.somepackage.SearchRequest;

public class Dummy {
    public static void main(String[] args) {

        SearchRequest srq = SearchRequest.newBuilder()
                .addSomeValue( "Arinodm")
                .setPageNumber(5)
                .build();

        System.out.println(srq);
//        System.out.println("hellow");
    }
}

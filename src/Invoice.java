import java.util.ArrayList;
import java.util.Scanner;

public class Invoice
{
    private Address customerAddress;

    private LineItem lineItems;

    private ArrayList<String> lineItemArrayList;
   // ArrayList<LineItem> lineItemArrayList = new ArrayList<LineItem>();

    int amtDue;


    public Invoice()
    {
        lineItemArrayList = new ArrayList<String>();
        lineItems = new LineItem();
        customerAddress = new Address();
    }

    /**
     * Uses SafeInput to collect the data for lineItems in the Invoice
     */
    public void getInvoiceData()
    {

        boolean done = true;
        //get line Item data
        do{
            Scanner in = new Scanner(System.in);

            //product & quantity
            lineItems.getLineItemData();
            String data ="";
            data += lineItems.getProduct().getName();
            data += lineItems.getProduct().getUnitPrice();
            data += lineItems.getQuantity();
            data += lineItems.getLineTotal();
            lineItemArrayList.add(data);

            //System.out.printf("%-30s %-30s %-30s %-30s",lineItemArrayList);



            done = SafeInput.getYNConfirm(in, "Would you like to enter more data?");

        }while(done);
    };

    /**
     * Uses SafeInput to collect the data for the address fields
     */
    public void getAddressData()
    {
        customerAddress.getAddress();
    };



    //private double getTotalAmtDue()
    //{
        //amtDue += lineItems.getLineTotal();
        //return amtDue;
   // };

    /**
     * generates a display to the console of the invoice data
     */
    public void displayInvoice()
    {
        System.out.println("Invoice \n");
        System.out.println(customerAddress.getTitle());
        System.out.println(customerAddress.getStreet());
        System.out.println(customerAddress.getCity() + ", " + customerAddress.getState() + " " + customerAddress.getZip());

        System.out.println("=====================================================");//^done
        System.out.printf("%-30s %-30s %-30s %-30s", "Item", "Qty", "Price", "Total");



        //System.out.print(lineItemArrayList);


       // System.out.print( lineItemArrayList + "\n");
        for (String list : lineItemArrayList) {
            System.out.println("\n");
            System.out.printf(list);

        }


        System.out.println("\n=====================================================");

        //System.out.println(amtDue);


    };

}

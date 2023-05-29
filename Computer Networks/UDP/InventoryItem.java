
public class InventoryItem {

   private String itemId;
   private String itemDescription;
   private double unitPrice;
   private int inventoryCount;

   // Contstuctor Method
   public InventoryItem(String itemId, String itemDescription, double unitPrice, int inventoryCount) {
      this.itemId = itemId;
      this.itemDescription = itemDescription;
      this.unitPrice = unitPrice;
      this.inventoryCount = inventoryCount;
   }

   // Getter methods
   public String getItemId() {
      return itemId;
   }

   public String getDescription() {
      return itemDescription;
   }

   public double getPrice() {
      return unitPrice;
   }

   public int getInventory() {
      return inventoryCount;
   }

   public String toString() {

      String column1Format = String.format("%-9.9s", this.getItemId());
      String column2Format = String.format("%-30.30s", this.getDescription());
      String column3Format = String.format("%-11.11s", this.getPrice());
      String column4Format = String.format("%-15.15s", this.getInventory());
      return column1Format + " " + column2Format + " " + column3Format + " " + column4Format;
      // return System.out.format(formatInfo, this.getItemId(),
      // this.getDescription(),this.getPrice(), this.getInventory() + "\n");
   }

}
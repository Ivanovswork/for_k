class Exp extends Element_of_record {
    public Exp(String amount, String type) {
        super(amount, type);
    }

    public Exp() {
        super();
    }

    public String getAmount(){
        return amount;
    }

    public String getType(){
        return type;
    }

    public void setAmount(String amount){
        this.amount = amount;
    }

    public void setType(String type){
        this.type = type;
    }

    public void show(){
        System.out.printf("Expense value = %s, type of Expense - %s\n", this.amount, this.type);
    }
}
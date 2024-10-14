class In extends Element_of_record {
    public In(String amount, String type) {
        super(amount, type);
    }

    public In() {
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
        System.out.printf("Income value = %s, type of income - %s\n", this.amount, this.type);
    }
}
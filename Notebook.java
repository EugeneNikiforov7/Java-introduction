package s06dz;

public class Notebook {
    String model;
    int op, ssd, diagonal;

    public Notebook(String model, int op, int ssd, int diagonal){
        this.model = model;
        this.op = op;
        this.ssd = ssd;
        this.diagonal = diagonal;
    }

    public boolean isBetter(Notebook nb){
        return (model == "" | model.equalsIgnoreCase(nb.model))
                        && (op == 0 | op <= nb.op)
                        && (ssd == 0 | ssd <= nb.ssd)
                        && (diagonal == 0 | diagonal <= nb.diagonal);
    }

    public String toStringNotEmpty(){
        String result = "";
        if (model !=""){ result+="Модель: \""+model+"\", ";}
        if(op>0) {result+="память "+op+"Гб, ";}
        if (ssd>0) {result+="ССД "+ssd+ "Гб, ";}
        if (diagonal>0) {result+="экран "+diagonal+"\"";}
        return result;
    }

    @Override
    public String toString(){
        return "Модель: \""+model+"\", память "+op+"Гб, ССД "+ssd+"Гб, экран "+diagonal+"\".";
    }
}

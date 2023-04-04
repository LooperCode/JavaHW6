package JavaHW6;

public class Notebook {
    String name;
    String ramSize;
    String hardDvc;
    String osVersion;


    public Notebook (String name, String ramSize, String hardDvc, String osVersion){
        this.name = name;
        this.ramSize = ramSize;
        this.hardDvc = hardDvc;
        this.osVersion = osVersion;
    }

    public String getName(){
        return this.name;
    }

    public String getRAMSize(){
        return this.ramSize;
    }

    public String getHardDvc(){
        return this.hardDvc;
    }

    public String getOsVersion(){
        return this.osVersion;
    }

    @Override
    public String toString(){
        return "\n"+name + "\nRAM: " + ramSize + " GB"
                + "\nHARD: " + hardDvc  + "\nOS: " + osVersion + "\n_____________________";
    }


}

package api;

import java.util.ArrayList;

public class Arguments {
    private ArrayList<String> names;
    private ArrayList<Integer> nums;

    public Arguments(){}
    public Arguments(ArrayList<String> names, ArrayList<Integer> nums) {
        this.names = names;
        this.nums = nums;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }
}

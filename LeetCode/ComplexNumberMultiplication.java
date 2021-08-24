class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] num1Split = a.split("\\+");
        String[] num2Split = b.split("\\+");
        
        int num1I = Integer.parseInt(num1Split[1].split("i")[0]);
        int num2I = Integer.parseInt(num2Split[1].split("i")[0]);
        int num1 = Integer.parseInt(num1Split[0]);
        int num2 = Integer.parseInt(num2Split[0]);
        
        StringBuilder res = new StringBuilder();
        res.append(num1 * num2 + -1*num1I * num2I);
        res.append("+");
        res.append(num1I * num2 + num2I * num1);
        res.append("i");
        return res.toString();
    }
}

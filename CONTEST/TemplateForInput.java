public class TemplateForInput {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        // BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(input.nextToken());
        while(t-- > 0)
        {
            input = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(input.nextToken());
            int[][] shops = new int[n][3];
            for (int i = 0; i < shops.length; i++) {
                input = new StringTokenizer(br.readLine());
                shops[i] = StringToInt(input);
            }
            long minCost = minCostCalculation(shops);
            bw.write(minCost + "\n");
        }

        br.close();
        bw.close();
    }
    
}

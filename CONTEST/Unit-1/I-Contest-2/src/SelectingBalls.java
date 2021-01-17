import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

public class SelectingBalls {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    public static void main(String[] args) throws IOException {
        Reader dr = new Reader();
//        Scanner sc = new Scanner(System.in);
        Long n = dr.nextLong(),m = dr.nextLong();
        ArrayList<Long> arr = new ArrayList<>();
        HashMap<Long,Long> arrMp = new HashMap<>();
        HashMap<Long,Long> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr.add(dr.nextLong());
        }
        for (int i = 0; i < n; i++) {
            if(mp.containsKey(arr.get(i)))
                mp.put(arr.get(i),mp.get(arr.get(i))+1);
            else
                mp.put(arr.get(i), (long) 1);
        }
        long cal;
        for (Long key : mp.keySet())
        {
            if(mp.get(key)%2 == 0)
                cal = (mp.get(key)/2)*(mp.get(key) - 1);
            else
                cal = (mp.get(key))*((mp.get(key) - 1)/2);
            arrMp.put(key, cal);
        }
        long total = 0;
        for (Long key : mp.keySet()) {
            total += arrMp.get(key);
        }

        for (int i = 0; i < n; i++) {
            long temp = total - arrMp.get(arr.get(i));
            if((mp.get(arr.get(i))-1) > 1) {
                if((mp.get(arr.get(i)) - 1)%2 == 0)
                    cal = ((mp.get(arr.get(i)) - 1)/2)*((mp.get(arr.get(i)) - 2));
                else
                    cal = ((mp.get(arr.get(i)) - 2)/2)*((mp.get(arr.get(i)) - 1));
                temp += cal;
            }
            System.out.println(temp);
        }
    }
}

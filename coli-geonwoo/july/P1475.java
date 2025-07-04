
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] cnt = new int[10];
        char [] k = String.valueOf(br.readLine()).toCharArray();

        for(int i=0; i<k.length; i++) {
            cnt[k[i]-'0']++;
        }

        int result = (int)Math.ceil(((double)cnt[6] + cnt[9])/2);

        for(int i=0; i<10; i++) {
            if(i==6 || i==9){
                continue;
            }
            result = Math.max(result,cnt[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}

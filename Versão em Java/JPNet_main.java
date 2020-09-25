import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JPNet_main {
    public static void main(String[] args) throws IOException {

//      ------------------------------ READING COMMAND FILE ------------------------------

//        File file = new File("/Users/B.Tinti/OneDrive/IDE/InteliJ/pibiti/01/inJava.txt"); //MAC
        File in = new File("C:\\Users\\User\\OneDrive\\IDE\\InteliJ\\pibiti\\01\\inJava.txt"); //WINDOWS
        BufferedReader data = new BufferedReader(new FileReader(in));

        File out = new File("C:\\Users\\User\\OneDrive\\IDE\\InteliJ\\pibiti\\01\\outJava.txt"); //WINDOWS
        FileWriter outW = new FileWriter(out);

        // overall
        String over = data.readLine();
        Integer OVER =  Integer.valueOf(over);
        for (int D = 0; D < OVER; D++){
            System.out.println("Process nº: " + (D + 1));
            String Ds = String.valueOf(D + 1);
            outW.write("Process nº: " + Ds + "\r");

        // run
        String run = data.readLine();
        Integer RUN =  Integer.valueOf(run);
        //        MP
        ArrayList<ArrayList> mp = new ArrayList<>();
        ArrayList<String> DM = new ArrayList<String>(Arrays.asList(data.readLine().split(";")));
        for (String i : DM){
            ArrayList<String> k = new ArrayList<String>(Arrays.asList(i.split(",")));
            mp.add(k);
        }
        //        MM
        ArrayList<ArrayList> mm = new ArrayList<>();
        ArrayList<String> DP = new ArrayList<String>(Arrays.asList(data.readLine().split(";")));
        for (String i : DP){
            ArrayList<String> k = new ArrayList<String>(Arrays.asList(i.split(",")));
            mm.add(k);
        }
        //        VB
            ArrayList<ArrayList> vba = new ArrayList<>();
            ArrayList<String> VB = new ArrayList<String>(Arrays.asList(data.readLine().split(";")));
            for (String i : VB){
                ArrayList<String> k = new ArrayList<String>(Arrays.asList(i.split(",")));
                vba.add(k);
            }
            ArrayList<Integer> vbb = new ArrayList<>();
            Random random = new Random();
            for (ArrayList i : vba){
                Object k0 = i.get(0);
                Integer K0 = Integer.valueOf((String) k0);
                Object k1 = i.get(1);
                Integer K1 = Integer.valueOf((String) k1);
                vbb.add(random.nextInt((K1-K0))+K0);
            }


        //        VC
        ArrayList<String> N = new ArrayList<String>(Arrays.asList(data.readLine().split(",")));
        ArrayList<Integer> vc = new ArrayList<>();
        for (String j : N){ vc.add(Integer.parseInt(j)); }

        for (int k = 0; RUN > k; k++){
            boolean op;

            int opq = 1;

            ArrayList<Integer> vb = new ArrayList<>();
            switch (opq){
                case 0:
                    for (int i : vbb){
                        if (i == 0){
                            vb.add(0);
                        } else vb.add(1);
                    }
                case 1:
                    int Kk = vbb.get(0);
                    for (int i : vbb){
                        if (i <= Kk) Kk =i;
                    } for (int i = 0; vbb.size() > i; i++){
                    if (vbb.get(i) == Kk) vb.add(1);
                    else vb.add(0);
                } ArrayList<Integer> jose = new ArrayList<>();
                    for (int i : vbb){ jose.add(i - Kk); }
                    for (int i = 0; jose.size() > i; i++){ if (jose.get(i) <= 0) jose.set(i,vbb.get(i)); }
//                    System.out.println(vbb);
                    vbb = jose;
//                    System.out.println(vbb);
            }

//            multVetMat
            ArrayList<Integer> r = new ArrayList<>();
            for (int i = 0; i < mm.get(0).size(); i++) {
                int q = 0;
                for (int j = 0; j < vc.size(); j++) {
                    Object ww = mm.get(j).get(i);
                    Integer WW = Integer.valueOf((String) ww);
                    q += WW * vc.get(j);
                }
                r.add(q);
            } //System.out.println("(1) r " + r);
//                compMat
                int b = 0;
                for (int i = 0; i < vb.size(); i = i + 1) {
                    if (vb.get(i) >= r.get(i)) {
                        b += 0;
                    } else {
                        b++;
                    }
                }
                if (b == 0) {
                    op = true;
                } else {
                    op = false;
                }
            if (op){
//                dimMat
                ArrayList<ArrayList> z = new ArrayList<>();
                if (mp.size() != mm.size()) {
                    System.out.println("ERROR: Tamanhos incompativeis {dimMat}");
                } else {
                    for (int i = 0; i < mp.size(); i++) {
                        ArrayList<Integer> m = new ArrayList<>();
                        for (int j = 0; j < mp.get(0).size(); j++) {
                            Object c = mp.get(i).get(j);
                            Integer C =  Integer.valueOf((String) c);
                            Object a =  mm.get(i).get(j);
                            Integer A =  Integer.valueOf((String) a);
                            m.add(A - C);
                        }
                        z.add(m);
                    } //System.out.println("(3) z " + z);
                }
//                multVetMat
                ArrayList<Integer> R = new ArrayList<>();
                for (int i = 0; i < z.get(0).size(); i++) {
                    int q = 0;
                    for (int j = 0; j < vc.size(); j++) {
                        ArrayList<Integer> W = z.get(j);
                        q += (int) W.get(i) * vc.get(j);
                    }
                    R.add(q);
                } //System.out.println("(4) R " + R);
//                somVet
                ArrayList<Integer> Z = new ArrayList<>();
                if (R.size() != vb.size()) {
                    System.out.println("ERROR: Tamanhos incompativeis {somVet}");
                } else {
                    for (int i = 0; i < R.size(); i++) {
//                        System.out.println(R.get(i) + " + " + vb.get(i));
                        Z.add(R.get(i) + vb.get(i));

                    } //System.out.println("(5) Z " + Z);
//                    System.out.println(Z);
                }
                vb = Z;
//                vc - random
//                Random random = new Random();
                ArrayList<Integer> v = new ArrayList<>();
                for (int i = 0; i < vc.size(); i++) {
                    v.add(random.nextInt(2));
                }
                vc = v;
//                print
                System.out.println((k + 1) + "; vb: " + vb + "; vc: " + vc + ";");
                String ks = String.valueOf((k + 1));
                String vbs = String.valueOf(vb);
                outW.write(ks + "; " + vbs + "\r");

                // EVITAR QUE OS NÚMEROS NEGATIVOS
                for (int i = 0; i < vb.size(); i++){
                    if (vb.get(i) < 0){
                        vb.set(i,0);
                    }
                } // EVITAR QUE OS NÚMEROS NEGATIVOS

            } else {
//                System.out.println();
                System.out.println((k + 1) + "; ERROR!" + "; vb: " + vb + "; vc: " + vc  + ";");
//                System.out.println((k + 1) + "; vb: " + vb);
//                System.out.println((k + 1) + "; vc: " + vc);
//                System.out.println();
                String ks = String.valueOf(k);
                outW.write(ks + "; ERROR! \r");
//                Random random = new Random();
                ArrayList<Integer> v = new ArrayList<>();
                for (int i = 0; i < vc.size(); i++) {
                    v.add(random.nextInt(2));
                }
                vc = v;
                }
            }
        }
        data.close();
        outW.close();
    }
}

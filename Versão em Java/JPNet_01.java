import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JPNet_01 {

    //    MatrixP = Matriz +
    ArrayList<ArrayList> MP;
    //    MatrixM = Matrix -
    ArrayList<ArrayList> MM;
    //    VectorB = Vetor de inicio
    ArrayList<Integer> VB;
    //    VectorC = Vetor de comando
    ArrayList<Integer> VC;

    JPNet_01(ArrayList<ArrayList> MatrixP, ArrayList<ArrayList> MatrixM, ArrayList<Integer> VectorB, ArrayList<Integer> VectorC) {

        MP = MatrixP;
        MM = MatrixM;
        VB = VectorB;
        VC = VectorC;

    }

    /*   ler o arquivo
    public void readFile(String save) throws IOException {

        File file = new File(save);

        BufferedReader data = new BufferedReader(new FileReader(file));

//        MP
        ArrayList<ArrayList> dm = new ArrayList<>();
        ArrayList<String> DM = new ArrayList<String>(Arrays.asList(data.readLine().split(";")));
        for (String i : DM){
            ArrayList<String> k = new ArrayList<String>(Arrays.asList(i.split(",")));
            dm.add(k);
        }
        MP = dm;

//        MM
        ArrayList<ArrayList> dp = new ArrayList<>();
        ArrayList<String> DP = new ArrayList<String>(Arrays.asList(data.readLine().split(";")));
        for (String i : DP){
            ArrayList<String> k = new ArrayList<String>(Arrays.asList(i.split(",")));
            dp.add(k);
        }
        MM = dp;

//        VB
        ArrayList<String> M = new ArrayList<String>(Arrays.asList(data.readLine().split(",")));
        ArrayList<Integer> m = new ArrayList<>();
        for (String i : M){ m.add(Integer.parseInt(i)); }
        VB = m;

//        VC
        ArrayList<String> N = new ArrayList<String>(Arrays.asList(data.readLine().split(",")));
        ArrayList<Integer> n = new ArrayList<>();
        for (String j : N){ n.add(Integer.parseInt(j)); }
        VC = n;
    }*/

    //    maior valor de um vetor
    public ArrayList<Integer> maiValVet(ArrayList<Integer> v) {

        ArrayList<Integer> V = new ArrayList<>();

        int x = v.get(0);
        int I = 0;
        for (int i : v) {
            if (x <= v.get(i)) {
                x = v.get(i);
                I = i;
            }
        }
        V.add(x);
        V.add(I + 1);
        return V;
    }


    //    menor valor superior e diferente de zero
    public ArrayList<Integer> menValdifZer(ArrayList<Integer> n) {

        ArrayList<Integer> V = new ArrayList<>();

        int v = n.get(0);
        int N = n.size();
        int I = 0;

        if (v == 0) {
            for (int j = 0; j == N; j++) {
                if (n.get(j) != 0 && n.get(j) > 0) {
                    v = n.get(j);
                    I = j;
                }
            }
        }
        for (int i = 0; i == N; i++) {
            if (n.get(i) < v && n.get(i) != 0 && n.get(i) > 0) {
                v = n.get(i);
                I = i;
            }
        }
        V.add(v);
        V.add(I);

        return V;
    }

    //    menor valor de um vetor
    public ArrayList<Integer> menValVet(ArrayList<Integer> v) {

        ArrayList<Integer> z = new ArrayList<>();
        int x = v.get(0);
        int I = 0;

        for (int i = 0; i == v.size(); i++) {
            if (x == v.get(i)) {
                x = v.get(i);
                I = i;
            }
        }
        z.add(x);
        z.add(I);
        return z;
    }


    //    Matriz aleatoria binaria t por t
    public ArrayList<ArrayList<Integer>> randomMat(int t) {

        Random random = new Random();

        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int i = 0; i == t; i++) {
            ArrayList<Integer> c = new ArrayList<>();
            for (int j = 0; j == t; j++) {
                c.add(random.nextInt(2));
            }
            l.add(c);
        }
        return l;
    }

    public void write(){
//        run; vb; vc; vb'
    }

    //  Vetor aleatorio binario de tamanho t
    public ArrayList<Integer> randomVet(int t) {
        Random random = new Random();
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            v.add(random.nextInt(2));
        }

        return v;
    }


    //    multiplica matrizes por um vetor
    public ArrayList<Integer> multVetMat(ArrayList<Integer> v, ArrayList<ArrayList> m) {
        System.out.println("-multVetMat-");
        ArrayList<Integer> r = new ArrayList<>();
        System.out.println("entrada: " + v);
        System.out.println("entrada: " + m);
            for (int i = 0; i < m.get(0).size(); i++) {
                int q = 0;
                for (int j = 0; j == v.size(); j++) {
                    q = q + (int) m.get(j).get(i) * v.get(j);
                }
                r.add(q);
            }
           // System.out.println("ERROR: Tamanho do Vetor ou Matriz incompativeis {multVet}");
        System.out.println("saida: " + r);
        return r;
    }


    //  soma dois vetores de tamanhos iguais
    public ArrayList<Integer> somVet(ArrayList<Integer> m, ArrayList<Integer> n) {

        ArrayList<Integer> z = new ArrayList<>();
        System.out.println("entrada m: " + m);
        System.out.println("entrada n: " + n);
        if (m.size() != n.size()) {
            System.out.println("ERROR: Tamanhos incompativeis {somVet}");
        } else {
            for (int i = 0; i < m.size(); i++) {
                z.add(m.get(i) + n.get(i));
            }
        }
        System.out.println("saida z: " + z);
        return z;
    }


    //    diminui duas matrizes de tamanhos iguais
    public ArrayList<ArrayList> dimMat(ArrayList<ArrayList> D, ArrayList<ArrayList> d) {
        System.out.println("-dimMat-");
        ArrayList<ArrayList> z = new ArrayList<>();
        System.out.println("entrada: " + D);
        System.out.println("entrada: " + d);
        if (D.size() != d.size()) {
            System.out.println("ERROR: Tamanhos incompativeis {dimMat}");
        } else {
            for (int i = 0; i < D.size(); i++) {
                ArrayList<Integer> m = new ArrayList<>();
                for (int j = 0; j < D.get(0).size(); j++) {
                    int b = (int) D.get(i).get(j);
                    int a = (int) d.get(i).get(j);
                    m.add(a - b);
                }
                z.add(m);
            }
        }
        System.out.println("saida: " + z);
        return z;
    }

    //    compara duas matrizes de tamanhos iguais
    public boolean compMat(ArrayList<Integer> m, ArrayList<Integer> n) {
        System.out.println("-compMat-");
        int b = 0;
            for (int i = 0; i < m.size(); i = i + 1) {
                if (m.get(i) >= n.get(i)) {
                } else {
                    b = b + 1;
                }
            }
            if (b == 0) {
                System.out.println("true");
                return true;
            } else {
                System.out.println("false");
                return false;
            }
    }

    //    operacoes
    public Object mL(ArrayList<Integer> n, ArrayList<Integer> m, ArrayList<ArrayList> dm, ArrayList<ArrayList> dp) {
        if (compMat(m, multVetMat(n, dm))) {
            return somVet(multVetMat(n, dimMat(dp, dm)), m);
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException{

        File file = new File("/Users/B.Tinti/OneDrive/IDE/InteliJ/pibiti/01/inJava.txt");
        BufferedReader data = new BufferedReader(new FileReader(file));

        // run
        int run = data.read();

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
        ArrayList<String> M = new ArrayList<String>(Arrays.asList(data.readLine().split(",")));
        ArrayList<Integer> vb = new ArrayList<>();
        for (String i : M){ vb.add(Integer.parseInt(i)); }

        //        VC
        ArrayList<String> N = new ArrayList<String>(Arrays.asList(data.readLine().split(",")));
        ArrayList<Integer> vc = new ArrayList<>();
        for (String j : N){ vc.add(Integer.parseInt(j)); }
        /*

//        [[1, 0, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1]]
        ArrayList<ArrayList> mp = new ArrayList<>();
        ArrayList<Integer> mp1 = new ArrayList<>(); mp1.add(1); mp1.add(0); mp1.add(0); mp1.add(0);
        ArrayList<Integer> mp2 = new ArrayList<>(); mp2.add(0); mp2.add(1); mp2.add(1); mp2.add(0);
        ArrayList<Integer> mp3 = new ArrayList<>(); mp3.add(0); mp3.add(0); mp3.add(0); mp3.add(1);
        mp.add(mp1); mp.add(mp2); mp.add(mp3);

        System.out.println("mp");
        System.out.println(mp); System.out.println(mp.size());

//        [[0, 0, 0, 0], [1, 0, 0, 0], [0, 1, 1, 0]]
        ArrayList<ArrayList> mm = new ArrayList<>();
        ArrayList<Integer> mm1 = new ArrayList<>(); mm1.add(0); mm1.add(0); mm1.add(0); mm1.add(0);
        ArrayList<Integer> mm2 = new ArrayList<>(); mm2.add(1); mm2.add(0); mm2.add(0); mm2.add(0);
        ArrayList<Integer> mm3 = new ArrayList<>(); mm3.add(0); mm3.add(1); mm3.add(1); mm3.add(0);
        mm.add(mm1); mm.add(mm2); mm.add(mm3);

        System.out.println("mm");
        System.out.println(mm); System.out.println(mm.size());

//        [2, 0, 1, 0]
        ArrayList<Integer> vb = new ArrayList<>();
        vb.add(2); vb.add(0); vb.add(1); vb.add(0);

        System.out.println("vb");
        System.out.println(vb); System.out.println(vb.size());

//        [1, 0, 0]
        ArrayList<Integer> vc = new ArrayList<>();
        vc.add(1); vc.add(0); vc.add(0);

        System.out.println("vc");
        System.out.println(vc); System.out.println(vc.size());
*/
        System.out.println("---------------");

        for (int k = 0; k <= run; k++) {

            JPNet_01 test = new JPNet_01(mp, mm, vb, vc);

            ArrayList<Integer> jpn = (ArrayList<Integer>) test.mL(vc,vb,mm,mp);
            System.out.println(jpn);
            vb = jpn;
            vc = test.randomVet(3);
        }

        System.out.println("----------");

    }
}

import java.io.*;
interface Scaning
{
    int ctscan = 7000;
    int mri = 6000;
    int sonography = 700;
}

interface LabTest
{
    int bloodTest = 500;
    int urinTest = 700;
    int hiv = 400;
}

interface Rooms
{
    int ACRoom = 2000;
    int NonACRoom = 500;
}



class Patient
{
    protected String Pname,condition;
    protected int age,wight,bp,puls;




    void input()throws IOException
    {
        BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter The Patient Name :- ");
        Pname = Br.readLine();
        System.out.println("Enter The Age Of Patient :- ");
        age = Integer.parseInt(Br.readLine());
        System.out.println("Enter The Wight Of Patient :- ");
        wight = Integer.parseInt(Br.readLine());
        System.out.println("Enter The BP Of Patient :- ");
        bp = Integer.parseInt(Br.readLine());
        System.out.println("Enter The Pulls Of Patient :- ");
        puls= Integer.parseInt(Br.readLine());
        System.out.println("Enter The Condition Of Patient MPD/PPD");
        condition = Br.readLine();

    }
    void show()
    {
        System.out.println("Age Of Patient   :-  "+age);
        System.out.println("Wight Of Patient :-  "+wight);
        System.out.println("BP Of Patient    :-  "+bp);
        System.out.println("Pulls Of Patient :-  "+puls);
    }
    String Con()
    {
        return (condition);
    }
}


class Doctor
{
    protected String Dname;
    protected String Work;

    void input()throws IOException
    {
        BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter The Doctor Name :- ");
        Dname = Br.readLine();
        System.out.println("Work Of Doctor :- ");
        Work = Br.readLine();
    }
    String WO()
    {
        return (Work);
    }
}


class BILL implements Scaning,LabTest,Rooms {

    void HospitalBill(Doctor X, Patient Y, int... Tests) {

        if (X.Work.equals("OPD")) {
            System.out.println("******  Bhau Che Hospital ******");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Patient Name       :-  " + Y.Pname);
            System.out.println("Doctor Appoint To  :-  " + X.Dname);
            System.out.println("....Condition Of Patient....");
            Y.show();
            System.out.println("-------------------------------------------------------------");
            System.out.println("Hospital Charge  :-  Rs 200");
            System.out.println("Doctor Charge    :-  Rs 200");
            System.out.println("-------------------------------------------------------------");
            System.out.println("FEES             :-  Rs 400");

        } else {
            int Total=0;

            System.out.println("******  Bhau Che Hospital ******");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Patient Name       :-  " + Y.Pname);
            System.out.println("Doctor Appoint To  :-  " + X.Dname);
            System.out.println("....Condition Of Patient....");
            Y.show();
            System.out.println("-------------------------------------------------------------");
            System.out.println("LAB Tests :-");
            for (int x : Tests) {

                if (x==ctscan) {
                    System.out.println("CT-SCAN    :- " + x);
                } else if (x == mri) {
                    System.out.println("MRI        :- " + x);
                } else if (x == sonography) {
                    System.out.println("SONOGRAPHY :- " + x);
                } else if (x == bloodTest) {
                    System.out.println("BLOOD-TEST :- " + x);
                } else if (x == hiv) {
                    System.out.println("HVI-TEST   :- " + x);
                } else if (x == ACRoom) {
                    System.out.println("... Room Preferred To Admit ... ");
                    System.out.println("AC-ROOM    :- " + x);
                } else {
                    System.out.println("... Room Preferred To Admit ... ");
                    System.out.println("NonAC-ROOM :- " + x);
                }
                Total+=x;

            }
            System.out.println("Hospital Charge  :-  Rs 200");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Total Bill       :- "+(Total+200));


        }


    }

}
public class Hospital_Test implements Scaning, LabTest, Rooms {
    public static void main(String args[]) throws IOException {
        Doctor DocOBJ1 = new Doctor();
        Doctor DocOBJ2 = new Doctor();

        DocOBJ1.input();
        DocOBJ2.input();
        Patient Mohit = new Patient();
        Mohit.input();

        BILL Funct = new BILL();

        String Pcon = Mohit.Con().toUpperCase();
        String D1work, D2work;
        D1work = DocOBJ1.WO().toUpperCase();
        D2work = DocOBJ2.WO().toUpperCase();

        if (Pcon.equals(D1work)) {
            Funct.HospitalBill(DocOBJ1, Mohit);
//            System.out.println("if");
        } else {
            Funct.HospitalBill(DocOBJ2, Mohit, ctscan, urinTest, bloodTest, mri, ACRoom);

//            System.out.println("else");


        }
    }


}

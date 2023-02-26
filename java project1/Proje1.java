package Proje_1;

import java.util.Scanner;

public class Proje1 {
    public static void main(String[] args) {

            // Scanner class tanimlayin...
            Scanner scanner = new Scanner(System.in);


            // Kullanicidan ismini girmesini isteyin ve girilen ismin ilk hafrini buyuk harfe donusturun...

            System.out.println("İsminizi giriniz: ");
            String str = scanner.nextLine();
            String output = str.substring(0, 1).toUpperCase() + str.substring(1);


            // Kullanicinin girdigi ismi ekrana yazdirarak, " Ahmet hosgeldin, soyismini girer misin?" diye soralim...

            System.out.println("Hoşgeldin "+output +" soyismini girer misin?");
            String soyad=scanner.nextLine();



            // Kullanici nin ismini ve soyismini ilk harfi buyuk digerleri kucuk olacak sekilde yazdiralim...

            String soyadByk = soyad.substring(0, 1).toUpperCase() + soyad.substring(1);
            System.out.print(output + " " +soyadByk+" " );

            // Ekranda gorulen isim soyisim dogru ise "Y" tusuna basarak devam edilecek sekilde dongu olusturalim...
            String verilen;

            do{
                System.out.println("isminiz doğru ise Y tuşuna basarak devam ediniz:");
                verilen=scanner.next();
                // Eger kullanici "Y" haricinde bir tusa basarsa "Tercihinizi dogru yapmadiniz...Lutfen tekrar deneyin..."   ikazi verelim
                if (!verilen.equalsIgnoreCase("y"))
                    System.out.println("tercihinizi doğru yapmadınız...lütfen tekrar deneyiniz");
                // Kullaniciyi tekrar "Y" tusuna basana kadar donguye devam edelim...
            }while(!verilen.equalsIgnoreCase("y"));
            // Kullanici "Y" tusuna bastiginda "Isim ve Soyisminiz sisteme basarili bir sekilde kayit edilmistir..."
            // ikazi verelim
            System.out.println("isminiz ve soy isminiz sisteme başarılı bir şekilde kaydolmuştur");
            // Kullanici adi belirleme adimi ile devam edelim ->" Lutfen kullanici adnizi belirleyin...:"
            System.out.println("Lutfen kullanici adnizi belirleyin...:");
            String kullaniciadi=scanner.next();
            // Sifre belirleme ile devam edelim...->" Lutfen sifrenizi belirleyiniz...:"
            String sifre1;
            String sifre2;

            System.out.println("Lutfen şifrenizi belirleyin...:");
            sifre1=scanner.next();
            // Sifre tekrar girilmelidir -> " Sifrenizi tekrar giriniz...:"
            do{

                System.out.println("Sifrenizi tekrar giriniz...:");
                sifre2=scanner.next();
                // Girilen iki sifre birbiri ile ayni olmalidir... Degilse "Yanlis veya hatali bir sifre girdiniz,
                // lutfen tekrar deneyin..." ikazi verelim

                if (!sifre1.equals(sifre2))
                    System.out.println("Yanlis veya hatali bir sifre girdiniz, lutfen tekrar deneyin...");

                // Sifreler birbiri ile ayni ise "Tebrikler... "+ username + " kullanici adiyla sisteme kayit oldunuz..."
                // ikazi verelim...

            }while(!sifre1.equals(sifre2));
            System.out.println( "Tebrikler... "+ kullaniciadi + " kullanici adiyla sisteme kayit oldunuz...");

        }
}

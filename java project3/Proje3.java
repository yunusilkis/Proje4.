package Proje_3;

import java.util.*;

public class Proje3 {



  /*
     Bu proje %90 bir onceki projeden alinmistir... Ufak degisiklikler mevcuttur.. ClASS yapisinin sizlere sagladigi kolayligi
     bu proje ile daha iyi anlayacaksiniz... Bu class gerekli kodlamalar yapildiginda video da gorulen sonucun aynisini verecek
     sekilde duzenlenmelidir...
        - not :  Tek degisiklik = Bir onceki proje de her kullanicinin 1 tek hesap numarasi vardi... Burada her musteriye 2 adet
                 hesap tanimlanmasini istiyoruz...
              :  Ayrica musteriye ait hesaplar listelenirken gecen hafta yapilan hatayi giderecek sekilde her kullanicinin kendi banka
              hesaplarinin listelenmesini saglayiniz...
     * Bu Class da KIRMIZI olarak gorulen kodlar sizin tarafinizdan eklenecek kodlar ile calisir hale gelecekler...
     * Sizlerden asagida belirtilen-kullanilmis Class lari ayri ayri olusturmanizi ve asagida tanimli methodlarin icini doldurmanizi bekliyoruz...
     */


        public static void main(String[] args) {

            // Scanner Class tanimlayin...
            Scanner scan = new Scanner(System.in);

            // Banka Islemleri (Actions) Class indan bir liste olusturun...4 adet islem tanimlayin "Para_Yatir", "Para_Cek", "Transfer", "Cikis"...




            // Her musteri (Customer) icin 2 adet hesap (Account) tanimlayin.. Hesap sinifi hesap numarasi ve hesaptaki para miktarini icermeli...


            Account m1Account1 = new Account("1234",100);
            Account m1Account2 = new Account("4321",200);
            ArrayList<Account> m1Accounts = new ArrayList<>(Arrays.asList(m1Account1,m1Account2));
            Customer musteri1 = new Customer("User1", "pw1",m1Accounts);


            Account m2Account1 = new Account("5678",1000);
            Account m2Account2 = new Account("8765",2000);
            ArrayList<Account> m2Accounts = new ArrayList<>(Arrays.asList(m2Account1,m2Account2));
            Customer musteri2 = new Customer("User2", "pw2",m2Accounts);


            Account m3Account1 = new Account("9999",500);
            Account m3Account2 = new Account("1111",400);
            ArrayList<Account> m3Accounts = new ArrayList<>(Arrays.asList(m3Account1,m3Account2));
            Customer musteri3 = new Customer("User3", "pw3",m3Accounts);


            // Banka musterilerini Customer sinifindan objeler olusturarak liste olarak tanimlayin...Customer sinifinda bir musteriye ait

            // username, password ve birden fazla hesap (Account) bulunmalidir...Buna gore bu musterileri burada tanimlayin...

            ArrayList<Customer> musteriler = new ArrayList<>();
            musteriler.add(musteri1);
            musteriler.add(musteri2);
            musteriler.add(musteri3);

            // Asagidaki kodda KIRMIZI olarak gorulen yerler sizin olustiracaginiz siniflar ve yukarida tanimlayacaginiz objeler ile
            // normal olarak calisacaktir...
            Customer aktifKullanici;
            Account secilenHesap;

            while (true){
                System.out.println("Please enter your username: ");
                String username = scan.nextLine();
                System.out.println("Please enter your password: ");
                String password = scan.nextLine();

                // -> Bu methodu asagida hangi kullanicinin giris yaptigini belirlemek maksadiyla kullanacaksiniz, olusturun...
                aktifKullanici = confirmUsernameAndPassword(musteriler, username, password);

                if (aktifKullanici != null){
                    System.out.println("Basarili bir sekilde giris yaptiniz");
                    break;
                }
                System.out.println("Sistemde kayitli boyle bir kullanici bulunamadi.. Tekrar deneyin");
            }

            // Actions starts here
            Actions actionListe = new Actions();


            while (true){
                System.out.println("Yapmak istediginiz islemi seciniz...");
                for (int i = 0; i < actionListe.actions.size(); i++) {
                    System.out.println(actionListe.actions.get(i)+ " - " + (i+1));
                }
                int userChoice = scan.nextInt();

                switch (userChoice){

                    case 1:{
                        // Para yatirma ozelligini aktif hale getirin...
                        System.out.println("Hesaplarınız:");
                        for (Account hesaplar: aktifKullanici.accounts){
                            System.out.println(hesaplar.accountNumber  + " Bakiyeniz: " + hesaplar.fund);}
                        System.out.println("Hangi Hesaba Para Yatırmak İstiyorsunuz?");
                        String yatirmaSecim = scan.next();
                        Account secilenYatirmaHesabi;
                        secilenYatirmaHesabi=confirmAccountNumber(aktifKullanici,yatirmaSecim);
                        if (secilenYatirmaHesabi == null) {
                            System.out.println("Hatali hesap numarasi girdiniz...");
                            continue;
                        }
                        System.out.println("Lutfen yatırmak istediginiz para miktarini giriniz...: ");
                        int yatirilacakPara = scan.nextInt();
                        secilenYatirmaHesabi.fund=secilenYatirmaHesabi.fund+yatirilacakPara;
                        System.out.println("Yatırma İşleminiz Gerçekleşti.");
                        break;
                        /*
                    Kullaniciya ait hesaplari listeleyerek hangi hesap numarasina para yatirmak istedigini sorun...
                    Kullanicinin sectigi hesap numarasi hatali ise ikaz ederek tekrar basa dondurun...
                    Secim confirmAccountNumber(currentCustomer, chosen); methodu tarafindan dogrulanirsa
                    Ne kadar para yatirmak istedigini sorun...
                    Ve kullanicinin girdisini alarak hesaptaki para miktarini arttirin...
                     */
                    }

                    case 2: {

                        while (true){
                            // Burada artik sadece o kullaniciya ait banka hesaplari listeleniyor... CLASS kullanmainin faydalari...
                            System.out.println("Lutfen para cekmek istediginiz hesap numarasini giriniz...: ");
                            for (Account account : aktifKullanici.accounts) {
                                System.out.println(account.accountNumber + " Bakiyeniz: " +account.fund +"₺");
                            }
                            String secim = scan.next();
                            // confirmAccountNumber() methodunu kullanicinin dogru hesap bilgileri girdigini teyit etmek amacli kullanacaksiniz..
                            secilenHesap = confirmAccountNumber(aktifKullanici, secim);
                            if (secilenHesap == null) {
                                System.out.println("Hatali hesap numarasi girdiniz...");
                                continue;
                            }
                            System.out.println("Lutfen cekmek istediginiz para miktarini giriniz...: ");
                            int cekilecekPara = scan.nextInt();
                            // withdraw() methodunu kullanicinin hesabinda yeterli bakiye varsa bakiyesinden paranin dusulmesi,
                            // Yeterli bakiye yoksa kullanicinin uyarilmasi maksadiyla kullanacaksiniz...Olusturun
                            if (!withdraw(secilenHesap, cekilecekPara)){
                                break;
                            }
                            break;
                        }
                        break;
                    }

                    case 3:{
                        System.out.println("Bu İşlemi Şu An Gerçekleştiremiyoruz...");
                        break;
                    }

                    case 4: System.exit(1);

                    default:{
                        System.out.println("Başarılı bir secim yapmadiniz...");
                    }

                }
            }
        }

        // TODO - Asagidaki 3 methodun return tipini ve icerigini tanimlayin ki yukarida olmasi gerektigi gibi sonuc versinler...

        public static Customer confirmUsernameAndPassword(List<Customer> users, String username, String password){
            //eğer girilen username ve passw eşitse customer listesindeki bir elemanana, return aktifkullanıcı
            Customer aktifKullanici=null;
            for(Customer musteriler: users)
                if (username.equals(musteriler.username)&&password.equals(musteriler.password))
                    aktifKullanici=musteriler;
            return aktifKullanici;

        }


        public static Account confirmAccountNumber(Customer currentUser, String chosenAccount){
            Account secilenhesap =null;
            for(Account numaralar: currentUser.accounts)
                if (chosenAccount.contains(numaralar.accountNumber))
                   secilenhesap=numaralar;
            return secilenhesap;

        }

        public static boolean  withdraw(Account chosenAccount, int amountToWithdraw ){
            // withdraw() methodunu kullanicinin hesabinda yeterli bakiye varsa bakiyesinden paranin dusulmesi,
            // Yeterli bakiye yoksa kullanicinin uyarilmasi maksadiyla kullanacaksiniz...Olusturun
            boolean yeterliParaVarMi;
            if (chosenAccount.fund>=amountToWithdraw){
                chosenAccount.fund=chosenAccount.fund-amountToWithdraw;
            System.out.println(amountToWithdraw + "₺ Çekim İşleminiz Gerçekleşti ,Mevcut Bakiyeniz :"+chosenAccount.fund+ "₺" +"\n"+"Lütfen Paranızı Almayı Unutmayınz.");
            yeterliParaVarMi=true;
            }
            else {
                System.out.println("Hesabınızda Yeterli MiktardaBakiye Bulunmamaktadır.");
                yeterliParaVarMi=false;
            }
            return yeterliParaVarMi;
        }
    }


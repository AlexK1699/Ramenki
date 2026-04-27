import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.Arrays;

public class RamenkiFichiers {

    public static void lireFichier() {
        InputStream entree;
        try {
            entree = new BufferedInputStream(
                    new FileInputStream("ramenki.bin"));
            for (int i = entree.read(); i != -1; i = entree.read()) {
                System.out.println("Octet lu : " + i);
            }
            entree.close();
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void testerMethodes() {
        InputStream entree;
        try {
            entree = new BufferedInputStream(
                    new FileInputStream("ramenki.bin"));
            System.out.println("Disponibles : " + entree.available());
            System.out.println("Mark supporté : " + entree.markSupported());
            entree.mark(10);
            System.out.println("Octet 1 : " + entree.read());
            entree.skip(1);
            entree.reset();
            System.out.println("Retour à la marque : " + entree.read());
            entree.close();
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void ecrireTexte() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("ramenki.txt"));

            bw.write("Vernadskogo - 3 pièces - 500000€");
            bw.newLine();
            bw.write("Michurinski - 1 pièce - 75000€");
            bw.newLine();
            bw.write("Lobachevski - 5 pièces - 120000€");
            bw.newLine();

            bw.flush();
            bw.close();

            System.out.println("Texte écrit !");

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void ecrireAvecCodage() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("ramenki_utf8.txt"), "UTF-8"));
            bw.write("Île-de-France — район Раменки");
            bw.newLine();
            bw.write("Lobachevski — 5 pièces — 120000€");
            bw.newLine();
            bw.flush();
            bw.close();
            System.out.println("Fichier UTF-8 écrit !");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void lireAvecCodage() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("ramenki_utf8.txt"), "UTF-8"));
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println("UTF-8 lu : " + ligne);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void testerAppend() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("ramenki_append.txt"));

            bw.append("Vernadskogo")
                    .append(" - ")
                    .append('3')
                    .append(" pièces");

            bw.newLine();

            StringBuffer sb = new StringBuffer("Michurinski");
            bw.append(sb);

            bw.flush();
            bw.close();

            System.out.println("Append écrit !");

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // шаг 1 — запись
        OutputStream sortie;
        try {
            sortie = new BufferedOutputStream(
                    new FileOutputStream("ramenki.bin"));
            sortie.write(3);
            sortie.write(500);
            sortie.flush();
            sortie.close();
            System.out.println("Fichier écrit avec succès !");
        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // шаг 2 — чтение
        lireFichier();

        // шаг 2б — available, skip, mark, reset
        testerMethodes();

        ecrireAppartement();
        lireAppartement();
        ecrireTexte();
        lireTexte();
        lireAvecScanner();
        ecrireAvecCodage();
        lireAvecCodage();
        lireTexteModerne();
        testerRandomAccess();
        testerPath();
        testerFiles();
        testerAppend();
    }

    public static void ecrireAppartement() {
        try {
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("appartement.bin")));

            dos.writeDouble(500000);        // цена
            dos.writeInt(3);                // количество комнат
            dos.writeBoolean(true);         // сдан?
            dos.writeUTF("Vernadskogo");    // адрес

            dos.flush();
            dos.close();

            System.out.println("Appartement écrit !");

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void lireAppartement() {
        try {
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("appartement.bin")));

            double prix    = dis.readDouble();   // читаем цену
            int pieces     = dis.readInt();      // читаем комнаты
            boolean loue   = dis.readBoolean();  // читаем статус
            String adresse = dis.readUTF();      // читаем адрес

            System.out.println("Adresse : " + adresse);
            System.out.println("Prix : "    + prix);
            System.out.println("Pièces : "  + pieces);
            System.out.println("Loué : "    + loue);

            dis.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void lireTexte() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("ramenki.txt"));

            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println("Lu : " + ligne);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void lireAvecScanner() {
        try {
            Scanner scanner = new Scanner(
                    new File("ramenki.txt"));

            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                System.out.println("Scanner lu : " + ligne);
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void lireTexteModerne() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("ramenki.txt"))) {

            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println("Moderne lu : " + ligne);
            }

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void testerRandomAccess() {
        try {
            RandomAccessFile raf = new RandomAccessFile("ramenki_raf.bin", "rw");

            // записываем три цены
            raf.writeInt(50000);   // позиция 0
            raf.writeInt(75000);   // позиция 4
            raf.writeInt(120000);  // позиция 8

            // прыгаем на позицию 4 (второй int)
            raf.seek(4);

            // читаем второй int
            int prix = raf.readInt();
            System.out.println("Prix à position 4 : " + prix);

            // текущая позиция
            System.out.println("Position actuelle : " + raf.getFilePointer());

            raf.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void testerPath() {

        Path chemin = Paths.get("ramenki", "data", "appartements.txt");

        System.out.println("Nom : "        + chemin.getFileName());
        System.out.println("Parent : "     + chemin.getParent());
        System.out.println("Racine : "     + chemin.getRoot());
        System.out.println("Absolu : "     + chemin.toAbsolutePath());
        System.out.println("Est absolu : " + chemin.isAbsolute());
        System.out.println("Nb éléments : "+ chemin.getNameCount());
        System.out.println("Élément 0 : "  + chemin.getName(0));
    }

    public static void testerFiles() {
        try {
            Path chemin = Paths.get("ramenki_files.txt");

            // существует ли файл?
            System.out.println("Existe : " + Files.exists(chemin));

            // записываем список строк
            List<String> lignes = Arrays.asList(
                    "Vernadskogo - 3 pièces",
                    "Michurinski - 1 pièce",
                    "Lobachevski - 5 pièces"
            );
            Files.write(chemin, lignes);
            System.out.println("Fichier écrit !");

            // существует ли теперь?
            System.out.println("Existe : " + Files.exists(chemin));

            // читаем все строки сразу
            List<String> lues = Files.readAllLines(chemin);
            for (String ligne : lues) {
                System.out.println("Files lu : " + ligne);
            }

            // удаляем файл
            Files.delete(chemin);
            System.out.println("Fichier supprimé !");

            // существует ли ещё?
            System.out.println("Existe : " + Files.exists(chemin));

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
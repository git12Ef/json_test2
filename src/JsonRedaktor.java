import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonRedaktor extends JFrame {
    private JPanel mainPanel;
    private JButton saveButton;
    private JButton openButton;
    private JEditorPane jsonPole;
    private JButton addButton;

    public JsonRedaktor(){
       setContentPane(mainPanel);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(800,600);
       setVisible(true);
       openButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   String soderjimoe = new String(Files.readAllBytes(Paths.get("fruit.json")));
                   jsonPole.setText(soderjimoe);
               } catch (IOException el) {
                   System.out.println("Ошибка при открытие");
               }
           }
       });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  String izPolia = jsonPole.getText();
                    Writer writer=new FileWriter("fruit.json",false);
                        writer.write(izPolia);
                        writer.flush();

                } catch (IOException el) {
                    System.out.println("Ошибка при сохранении");
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    JSONObject jo =new JSONObject();
                    jo.put("fruit","Pineaple");
                    jo.put("size","Medium");
                    jo.put("color","N/a");
                    jo.put("weight","900");

                JSONArray ja = new JSONArray();
                    ja.add(jo);
                 jo =new JSONObject();
                jo.put("fruit","Malon");
                jo.put("size","Large");
                jo.put("color","Yellow");
                jo.put("weight","2300");
                ja.add(jo);

                jo =new JSONObject();
              jo.put("fruit",ja);

                    jsonPole.setText(jo.toJSONString());

            }
        });

    }
}
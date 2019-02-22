package me.bucklb.simpleBootdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import me.bucklb.simpleBootdemo.Domain.LargeHolder;
import me.bucklb.simpleBootdemo.Domain.Larger;
import me.bucklb.simpleBootdemo.Domain.SmallHolder;
import me.bucklb.simpleBootdemo.Domain.Smaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootRunner implements CommandLineRunner{

    // The bit we want to play with
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Runner is running ...");

        // EventSource will wait for text to be entered and call each of its observers' update method
        EventSource es=new EventSource();
        // Add a "default" observer by creating an update method via lambda
        es.addObserver((obj,arg)-> System.out.println("update A called with " +arg) );
        es.addObserver((obj,arg)-> System.out.println("update B called with " +arg) );
        new Thread(es).start();













        Gson gson = new GsonBuilder().create();

        // Dummied up json
        String jSon="{\n" +
                "\"a\": \"How?\",\n" +
                "\"b\": \"Now. Brown Cow\",\n" +
                "\"c\": \"number\"\n" +
                "}";

        // Can I build a generic object to map to?
        Object o = gson.fromJson(jSon,Object.class);





        // What does Dozer do if the classes don't match well
        Larger l = new Larger();
        l.setA("a");        l.setB("b");        l.setC("c");        l.setD("d");

        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(jSon);


        // Map the multi method class to the less methoded one
        System.out.println("=== Create new smaller from larger");
        Smaller s = modelMapper.map( l, Smaller.class );
        System.out.println( s + " from \n" + l );

        // Vice versa
        System.out.println("=== Create new larger from smaller");
        s.setA("A");
        s.setB("B");
        Larger L = modelMapper.map( s, Larger.class);
        System.out.println( L + " from \n" + s );

        // If we map on to an existing object
        System.out.println("=== Map from smaller to existing larger");
        l = modelMapper.map( s, Larger.class);
        System.out.println(l + " from \n" + s );

        System.out.println("=== nesting Large -> Large");
        LargeHolder lh = new LargeHolder();
        lh.setA("Alpha");
        lh.setB("Beta");
        lh.setC(l);
        l.setC("C");
//        l.setDee("D");
        LargeHolder lH=modelMapper.map( lh, LargeHolder.class);
        System.out.println(lH + " from \n" + lh );

        System.out.println("=== nesting Small -> Small");
        SmallHolder sh = new SmallHolder();
        sh.setA("ALPHA");
        sh.setB("BETA");
        sh.setC(s);
        SmallHolder sH = modelMapper.map( sh, SmallHolder.class);
        System.out.println(sH + " from \n" + sh );


        System.out.println("=== nesting Large -> Small");
        sH = null;
        sH = modelMapper.map( lh, SmallHolder.class );
        System.out.println(sH + "  from" + "\n" + lh );


        System.out.println("=== nesting Small -> Large");
        lH = null;
        lH = modelMapper.map( sh, LargeHolder.class );
        System.out.println(lH + "  from" + "\n" + sh );




    }
}

import java.util.Properties;
import java.util.Scanner;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

import java.util.Scanner;
import java.sql.*;

public class Kafkaproductproducer {
    public static void main(String[] args) {

        KafkaProducer producer;
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "producer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer(props);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("enter produduct table ");
            System.out.println("enter model ");
            String model = input.next();
            System.out.println("enter release_year ");
            String release_year = input.next();
            System.out.println("enter brand ");
            String brand = input.next();
            System.out.println("enter price ");
            int price = input.nextInt();
            System.out.println("enter seller name ");
            String seller_name = input.next();
            System.out.println("enter color ");
            String color = input.next();
            System.out.println("enter manufacture date ");
            String manufacture_date = input.next();


            String sendval = String.format("{'modelname':" + model + ",'release_year':" + release_year +" ,'brand':"+brand+",'price':"+price+",'seller_name':"+seller_name+",'color:"+color+",'manufacture_date':"+manufacture_date+"}");
            producer.send(new ProducerRecord("productdb", sendval));
//            producer.close();








            }
    }
}








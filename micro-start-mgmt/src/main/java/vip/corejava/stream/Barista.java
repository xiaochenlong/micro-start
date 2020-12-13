package vip.corejava.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 声明通道
 */
public interface Barista {

    String OUTPUT_CHANNEL = "output_channel";
    String INPUT_CHANNEL = "input_channel";


    @Input(INPUT_CHANNEL)
    SubscribableChannel loginput();

    @Output(Barista.OUTPUT_CHANNEL)
    MessageChannel logoutput();
}
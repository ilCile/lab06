package it.unibo.exceptions;

import java.io.IOException;

public class NetworkException extends IOException{
    private final String message;

    @Override
    public String toString() {
        return "NetworkException [message=" + message + "]";
    }

    public NetworkException(){
        this.message = "Network error: no response";
    }

    public NetworkException(String message){
        this.message = "Network error while sending message: " + message + ".";
    }
}

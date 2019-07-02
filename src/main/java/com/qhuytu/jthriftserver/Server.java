package com.qhuytu.jthriftserver;

import com.qhuytu.jthriftserver.services.NoteServiceImpl;
import org.apache.thrift.TMultiplexedProcessor;
import com.qhuytu.jthriftfiles.services.servicesConstants;
import com.qhuytu.jthriftfiles.services.NoteService;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.*;

public class Server {
    public static void main(String[] args) {
        try {
            run();
        } catch (TTransportException ex) {
            System.out.println("Can not start server: " + ex.getMessage());
        }
    }

    private static void run() throws TTransportException {
        TMultiplexedProcessor processor = new TMultiplexedProcessor();
        registerProcessor(processor);

        TServer.Args args = new TServer.Args(new TServerSocket(9090))
                .processor(processor)
                .transportFactory(new TFramedTransport.Factory());

        TServer server = new TSimpleServer(args);
        server.serve();
    }

    private static void registerProcessor(TMultiplexedProcessor processor) {
        processor.registerProcessor(servicesConstants.NOTESERVICE, new NoteService.Processor(new NoteServiceImpl()));
    }
}

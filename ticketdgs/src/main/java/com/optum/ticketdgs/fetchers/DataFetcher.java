package com.optum.ticketdgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.ticketdgs.generated.types.Ticket;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class DataFetcher {
    @Autowired
    private Faker faker;
    @DgsQuery
    public List<Ticket> allTickets(){
          return generateTickets();
    }

    @DgsQuery
    public Ticket getTicketByNo(int ticketNo){

        return generateTickets().stream().filter(t->t.getTicketNo()<ticketNo).findFirst().orElse(null);
    }


    private List<Ticket> generateTickets(){

        List<Ticket> tickets=new ArrayList<Ticket>();
        Ticket ticket;

        for(int i=0;i<100;i++){
            ticket=Ticket.newBuilder().ticketNo(faker.random().nextInt(100000))
                    .description(faker.address().country())
                    .openingDate(faker.date().toString())
                    .closingDate(faker.date().toString()).build();
          tickets.add(ticket);
        }

        return tickets;
    }

}

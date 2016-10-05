package com.todorov.resources;

import com.todorov.model.Message;
import com.todorov.resources.beans.MessageFilterBean;
import com.todorov.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Alex on 04.10.2016.
 */
@Path("/messages")
public class MessageResource {
    private MessageService messageService = new MessageService();

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
        if (filterBean.getYear() > 0){
            return messageService.getAllMessagesForYear(filterBean.getYear());
        }
        if (filterBean.getStart() >= 0 && filterBean.getSize() > 0){
            return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
        }
        return messageService.getAllMessages();
    }


    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id);
    }

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id, Message message){
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @GET
    @Path("/{messageId}")
    @Produces (MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long id){
        return messageService.getMessage(id);
    }

    @Path("/{messageId}/comments")
    @Produces (MediaType.TEXT_PLAIN)
    public CommentResource getCommentResource(){
        return new CommentResource();
    }
}

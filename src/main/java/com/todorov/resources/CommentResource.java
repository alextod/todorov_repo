package com.todorov.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Alex on 05.10.2016.
 */
@Path("/")
public class CommentResource {
    @GET
    public String test(){
        return "Sub resource";
    }

    @GET
    @Path("/{commentId}")
    public String getCommentById(@PathParam("commentId") long commentId,
                                 @PathParam("messageId") long messageId){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Message ID - ");
        stringBuilder.append(messageId);
        stringBuilder.append('\n');
        stringBuilder.append("Comment ID - ");
        stringBuilder.append(commentId);
        return stringBuilder.toString();
    }
}

package aiss.api.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Event;
import aiss.model.repository.ArtistListRepository;
import aiss.model.repository.MapArtistListRepository;

import java.net.URI;
import java.util.List;

@Path("/events")
public class EventsResource {
	
	    public static EventsResource _instance=null;
	    ArtistListRepository repository;
	    
	    private EventsResource(){
	        repository=MapArtistListRepository.getInstance();
	    }
	    
	    public static EventsResource getInstance()
	    {
	        if(_instance==null)
	            _instance=new EventsResource();
	        return _instance; 
	    }
	    
	    @GET
	    @Produces("application/json")
	    public List<Event> getAll()
	    {
	    	
	        return repository.getAllEvents();
	    }
	    
	    
	    @GET
	    @Path("/{id}")
	    @Produces("application/json")
	    public Event get(@PathParam("id") String id)
	    {
	        Event e = repository.getEvent(id);
	        if(e == null) {
	        	throw new NotFoundException("El evento con id = "+ id+ " no esta disponible");
	        }
	        
	        return e;
	    }
	    
	    @POST
	    @Consumes("application/json")
	    @Produces("application/json")
	    public Response addEvent(@Context UriInfo uriInfo, Event e) {
	    	if (e.getNombre() == null || "".equals(e.getNombre()))
	            throw new BadRequestException("El atributo nombre, es necesario.");
	        
	    	if (e.getFecha() == null || "".equals(e.getFecha()))
	    		 throw new BadRequestException("El atributo fecha, es necesario.Recuerda es un LocalDateTime.");

	        repository.addEvent(e);

	        // Builds the response. Returns the event the has just been added.
	        UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
	        URI uri = ub.build(e.getId());
	        ResponseBuilder resp = Response.created(uri);
	        resp.entity(e);            
	        return resp.build();

	    }
	    
	    
	    @PUT
	    @Consumes("application/json")
	    public Response updateSong(Event event) {
	    	Event oldEvent = repository.getEvent(event.getId());
	    	if(oldEvent== null){
	    		throw new BadRequestException("El evento es necesario.Recuerda que no es posible actualizar algo inexistente.");
	    	}
	    	if (oldEvent.getNombre() == null || "".equals(oldEvent.getNombre()))
	            throw new BadRequestException("El atributo nombre, es necesario.");
	        
	    	if (oldEvent.getFecha() == null || "".equals(oldEvent.getFecha().toString()))
	    		 throw new BadRequestException("El atributo fecha, es necesario.Recuerda es un LocalDateTime.");
	    	
	    	if (oldEvent.getDescripcion() == null || "".equals(oldEvent.getDescripcion()))
	    		 throw new BadRequestException("El atributo fecha, es necesario.Recuerda es un LocalDateTime.");
	    	
	    	if (oldEvent.getLugar() == null || "".equals(oldEvent.getLugar()))
	    		 throw new BadRequestException("El atributo fecha, es necesario.Recuerda es un LocalDateTime.");
	    	
	        return null;
	    }
	    
	    @DELETE
	    @Path("/{id}")
	    public Response removeSong(@PathParam("id") String eventId) {
	    	Event event2BRemove = repository.getEvent(eventId);
	    	if(event2BRemove == null) {
	    		throw new BadRequestException("El evento es necesario.Recuerda que no es posible borrar algo inexistente.");
	    	}else {
	    		repository.removeEvent(eventId);
	    	}
	        return Response.noContent().build();
	    }
	    
	}


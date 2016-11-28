package mjg.rest

import javax.ws.rs.*
import javax.ws.rs.core.*

@Path('/people')
class PersonResource {
    @Context 
    private UriInfo uriInfo
    
    PersonDAO dao = SqlPersonDAO.instance

    @GET @Produces( [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML] )
    List<Person> findAll() {
        dao.findAll();
    }

    @GET @Path("lastname/{like}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    List<Person> findByName(@PathParam("like") String like) {
        dao.findByLastName(like);
    }

    @GET @Path("{id}")
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response findById(@PathParam("id") long id) {
        Response.ok(dao.findById(id))
            .build()
    }

    @POST
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Response create(Person person) {
        dao.create(person);
        UriBuilder builder = UriBuilder.fromUri(uriInfo.requestUri).path("{id}")
        Response.created(builder.build(person.id))
            .entity(person)
            .build()
    }

    @PUT @Path("{id}")
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @Produces([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    Person update(Person person) {
        dao.update(person);
        person;
    }

    @DELETE @Path("{id}")
    Response remove(@PathParam("id") long id) {
        dao.delete(id);
        Response.noContent().build()
    }
}

package customers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

    @Override
    public EntityModel<Customer> toModel(Customer Customer) {

        return EntityModel.of(Customer, //
                linkTo(methodOn(CustomerController.class).one(Customer.getId())).withSelfRel(),
                linkTo(methodOn(CustomerController.class).all()).withRel("Customers"));
    }
}

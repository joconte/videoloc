package fr.epsi.jconte.refactoring;

import fr.epsi.jconte.refactoring.model.Customer;
import fr.epsi.jconte.refactoring.model.Movie;
import fr.epsi.jconte.refactoring.model.Rental;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Movie movie = new Movie("Vive la pizza", 10);
        Customer customer = new Customer("Jonathan");

        Rental rental = new Rental(movie, 10);

        customer.addRentals(rental);

        System.out.println(customer.statement());

    }
}

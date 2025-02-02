package com.bookparser;

public class Main {

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>https://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>" +
                "<small_image_url>https://images.gr-assets.com/books/1465675526s/16902.jpg</small_image_url>" +
                "</best_book>" +
                "</work>";

        // Parse response
        Book book = APIResponseParser.parse(response);

        // Output the parsed data
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publication Year: " + book.getPublicationYear());
        System.out.println("Average Rating: " + book.getAverageRating());
        System.out.println("Ratings Count: " + book.getRatingsCount());
        System.out.println("Image URL: " + book.getImageUrl());
    }
}
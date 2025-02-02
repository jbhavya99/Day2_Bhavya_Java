package com.bookparser;

public class APIResponseParser {

    public static Book parse(String response) {
        Book book = new Book();

        String[] titleStartTags = {"<work>", "<best_book>", "<title>"};
        String title = parse(response, titleStartTags, "</title>");
        book.setTitle(title);

        String[] authorStartTags = {"<work>", "<best_book>", "<author>", "<name>"};
        String author = parse(response, authorStartTags, "</name>");
        book.setAuthor(author);

        String[] pubYearStartTags = {"<work>", "<original_publication_year type=\"integer\">"};
        String pubYear = parse(response, pubYearStartTags, "</original_publication_year>");
        book.setPublicationYear(Integer.parseInt(pubYear));

        String[] avgRatingStartTags = {"<work>", "<average_rating>"};
        String avgRating = parse(response, avgRatingStartTags, "</average_rating>");
        book.setAverageRating(Double.parseDouble(avgRating));

        String[] ratingsCountStartTags = {"<work>", "<ratings_count type=\"integer\">"};
        String ratingsCountStr = parse(response, ratingsCountStartTags, "</ratings_count>");
        ratingsCountStr = ratingsCountStr.replace(",", "");
        book.setRatingsCount(Integer.parseInt(ratingsCountStr));

        String[] imageUrlStartTags = {"<work>", "<best_book>", "<image_url>"};
        String imageUrl = parse(response, imageUrlStartTags, "</image_url>");
        book.setImageUrl(imageUrl);

        return book;
    }

    // Overloaded parse method for handling multiple start rules (nested tags)
    public static String parse(String response, String[] startRules, String endRule) {
        String tempResponse = response;

        int startIndex = 0;
        // Iterate over the startRules array to handle nested tags
        for (String startRule : startRules) {
            startIndex = tempResponse.indexOf(startRule) + startRule.length();
        }

        int endIndex = tempResponse.indexOf(endRule, startIndex);
        tempResponse = tempResponse.substring(startIndex, endIndex);

        return tempResponse.trim();
    }
}
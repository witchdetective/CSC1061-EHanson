package edu.frcc.csc1061j.GettingToPhilosophy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     * that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        // String source = "https://en.wikipedia.org/wiki/Arithmetic";
        testConjecture(destination, source, 10);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination
     * or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, Integer limit) throws IOException {
        Integer zero = 0;
        if (limit.equals(zero)) { // When the limit of 10 is reached.
            System.out.println("Reached limit!");
            return;
        }
        if (source.equals(destination)) { // When the Philosophy page is found.
            System.out.println("Success!");
            return;
        }
        Document doc = null;
        Connection conn = Jsoup.connect(source);
        try {
            doc = conn.get();
        } catch (Exception e) {
            System.out.println("Could not open page. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }

        // select the content text and pull out the paragraphs.
        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");
        int openParen = 0; // Keeping track of open parenthesis.
        int closeParen = 0; // Keeping track of closed parenthesis.

        for (Element para : paragraphs) {
            Iterable<Node> iter = new WikiNodeIterable(para);
            for (Node node : iter) {
                for (Node child : node.childNodes()) {
                    if (child instanceof TextNode) {
                        // Parenthesis finding.
                        int index = child.toString().indexOf("(");
                        if (index > -1) {
                            openParen++;
                        }
                        index = child.toString().indexOf(")");
                        if (index > -1) {
                            closeParen++;
                        }
                    }
                    if (openParen == closeParen && child instanceof Element && child.hasAttr("href")) { // Checks for href outside of parenthesis.
                        String link = child.attr("href");
                        if (link != null && link != "" && link.indexOf("#") != 0) { // Checks for #, empty link, and null link.
                            link = "https://en.wikipedia.org" + link;
                            System.out.println(source + " has " + openParen + " parenthesis.");
                            System.out.println("The next link is: " + link);
                            testConjecture(destination, link, --limit);
                            return;
                        }
                    }
                }
            }

        }
        return;
    }
}

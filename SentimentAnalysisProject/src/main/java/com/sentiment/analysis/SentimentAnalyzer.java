package com.sentiment.analysis;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];
        review = review.toLowerCase();

        for (int i = 0; i < featureSet.length; i++) {
            for (String feature : featureSet[i]) {
                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    break;
                }
            }
        }
        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        return (opinion == 0) ? checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords) : opinion;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        String pattern = feature + " was ";
        for (String pos : posOpinionWords) {
            if (review.contains(pattern + pos)) return 1;
        }
        for (String neg : negOpinionWords) {
            if (review.contains(pattern + neg)) return -1;
        }
        return 0;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        String[] sentences = review.split("\\.");
        for (String sentence : sentences) {
            for (String pos : posOpinionWords) {
                if (sentence.contains(pos + " " + feature)) return 1;
            }
            for (String neg : negOpinionWords) {
                if (sentence.contains(neg + " " + feature)) return -1;
            }
        }
        return 0;
    }
}
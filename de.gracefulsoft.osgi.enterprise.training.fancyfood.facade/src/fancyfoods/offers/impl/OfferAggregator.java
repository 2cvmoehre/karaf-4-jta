package fancyfoods.offers.impl;

import java.util.List;

import fancyfoods.offers.CurrentOffer;
import fancyfoods.offers.SpecialOffer;

public class OfferAggregator implements CurrentOffer
{
    private List<SpecialOffer> offers;

    @Override
    public List<SpecialOffer> getCurrentOffers()
    {
        return offers;
    }

    /**
     * setter for Blueprint injection
     * 
     * @param offers
     */
    public void setOffers(List<SpecialOffer> offers)
    {
        this.offers = offers;
    }

    // bundle
}

#ASTROMANCY

- Esoteric app featuring a daily horoscope and a yes/no question and answer tarot
- Using 8 screens and 6 fragments*

##Astromancy App
###Screenshots of the app
![Main Page](HomePage.png)
![Horoscope main page](HoroscopeMain.png)
![Horoscope Today](HoroscopeToday.png)
![Tarot Question](TarotAsk.png)
![Tarot Answer Page](TarotAnswer.png)



##ENDPOINTS
###Horoscope
*POST https://aztro.sameerkumar.website/?starsign={STARSIGN}?day={YESTERDAY/TODAY/TOMORROW}*
With this post we're retrieving:
- Sign
- Description
- Current Date
- Color
- Lucky Number
- Compatibility
- Lucky Time
- Mood

###Tarot
*POST https://divineapi.com/api/1.0/get_yes_or_no_tarot.php* 
With this post we're retrieving:
- A card image- Card name
- Card Name
- **YES** or **NO** answer
- A description of the meaning of the card




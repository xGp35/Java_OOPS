// Simple authoring tool for creating and saving a set of eflash cards

Functional requirements
1. should be able to create a card - createCard()
2. should be able to save a card - saveCard()
3. needs to have a gui - build and display gui - go()

Actual answer

1. build and display the gui - go() - makes and registers eventListeners
// build and display gui
2. nextCard() - user wants to store that card in the list and create "new" card 
//- imo this must call saveCard()
// add current card to the list
// clear the text areas
3. saveCard() - call when user chooses 'Save' from the File menu, means
user wants to save all the cards in the current list as a 'set', 
(like quantumMechanics set, hollywoodTrivia, javaRules, etc)
// bring up the file dialog box
// let the user name and save the set
4. clearCard() - will be needed to clear the screen when 
    -> the user chooses "New" from file menu
    -> moves to the next card
// clear out the text areas
5. saveFile(File file) - called by the SaveMenuListener - does the actual file writing
// iterate through the list of cards and write each one out to a text file
// in a parseable way (in other words, with clear separation between parts)

# Evolutionary Image Generator
Genetic algorithm to form n squares into a given image

<h6>
Algorithm:
</h6>

1. Generate n (~1000 recommended) squares of 50 X 50 px and draw them on screen. The list of positions is the "DNA" of the generated image.
2. Mutate the DNA by replacing a random square with a new one.
3. If the new image has a greater "fitness" (is more similar to the given image) than the old image, save the DNA as the best fit. This new DNA will now be mutated upon (GOTO 2).
4. Else, revert back to current DNA and mutate another square (GOTO 2).

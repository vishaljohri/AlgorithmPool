__author__ = 'VISHAL'
import nltk
import numpy

english_vocab = set(w.lower() for w in nltk.corpus.words.words())
validWords = set()
c = [['a', 'b', 'c', 'f'], ['x', 'i', 'k', 't'], ['e', 't', 'd', 'a'], ['d', 'e', 'w', 'u']]


def formWordsRecursion(c, i, j, str, availableSpots):
    str += c[i][j]
    availableSpots[i][j] = False
    if len(str) > 2 and str in english_vocab:
        validWords.add(str)
    # down movement
    if i < len(c) - 1 and availableSpots[i + 1][j]:
        formWordsRecursion(c, i + 1, j, str, availableSpots)
    # up movement
    if i > 0 and availableSpots[i - 1][j]:
        formWordsRecursion(c, i - 1, j, str, availableSpots)
    # right movement
    if j < len(c[0]) - 1 and availableSpots[i][j + 1]:
        formWordsRecursion(c, i, j + 1, str, availableSpots)
    # left movement
    if j > 0 and availableSpots[i][j - 1]:
        formWordsRecursion(c, i, j - 1, str, availableSpots)
    # diagonal movements
    if i < len(c) - 1 and j < len(c[0]) - 1 and availableSpots[i + 1][j + 1]:
        formWordsRecursion(c, i + 1, j + 1, str, availableSpots)
    if i > 0 and j > 0 and availableSpots[i - 1][j - 1]:
        formWordsRecursion(c, i - 1, j - 1, str, availableSpots)
    if i < len(c) - 1 and j > 0 and availableSpots[i + 1][j - 1]:
        formWordsRecursion(c, i + 1, j - 1, str, availableSpots)
    if i > 0 and j < len(c[0]) - 1 and availableSpots[i - 1][j + 1]:
        formWordsRecursion(c, i - 1, j + 1, str, availableSpots)
    availableSpots[i][j] = True  # make the current position available


def frequencyImplementation():
    puzzle_letters = nltk.FreqDist('abcfxiktetdadewu')
    result = [w for w in english_vocab if len(w) > 2 and nltk.FreqDist(w) <= puzzle_letters]
    print result


if __name__ == "__main__":
    for i in range(0, len(c) - 1):
        for j in range(0, len(c[0]) - 1):
            str = ""
            availableSpots = numpy.ones((len(c), len(c[0])), dtype=bool)
            formWordsRecursion(c, i, j, str, availableSpots)
    print validWords
    print len(validWords)
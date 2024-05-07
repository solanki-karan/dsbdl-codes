def read_paragraph_from_file(file_path):
    try:
        with open(file_path, 'r') as file:
            paragraph = file.read()
            return paragraph
    except FileNotFoundError:
        print("File not found!")
        return None


def separate_words(paragraph):
    if paragraph is None:
        return None, None
    
    # Convert paragraph to lowercase for case-insensitive comparison
    paragraph = paragraph.lower()
    
    # Split the paragraph into words
    words = paragraph.split()

    # Count the occurrences of each word
    word_count = {}
    for word in words:
        word_count[word] = word_count.get(word, 0) + 1

    # Separate repeated and non-repeated words
    repeated_words = [word for word, count in word_count.items() if count > 1]
    non_repeated_words = [word for word, count in word_count.items() if count == 1]

    return repeated_words, non_repeated_words


def main():
    # File path of the input file
    file_path = "C:\\\\Users\\\\Vedant\\\\OneDrive\\\\Desktop\\\\Internship\\\\data science code\\\\11\\\\input.txt"
    
    # Read paragraph from file
    paragraph = read_paragraph_from_file(file_path)
    
    # Separate repeated and non-repeated words
    repeated_words, non_repeated_words = separate_words(paragraph)
    
    # Print the results
    if repeated_words is not None and non_repeated_words is not None:
        print("Repeated words:", repeated_words)
        print("Non-repeated words:", non_repeated_words)


if __name__ == "__main__":
    main()

def read_grammar_from_file(filename):
    with open(filename, 'r') as file:
        lines = file.readlines()
    return [line.strip().split('->') for line in lines]

def determine_chomsky_type(grammar):
    for rule in grammar:
        left, right = rule[0].strip(), rule[1].strip().split('|')

        # Type 3 grammar (Regular)
        if len(left) == 1 and all(len(r) <= 2 for r in right):
            if all(len(r) == 1 and r.islower() for r in right):
                return "正规文法"

        # Type 2 grammar (Context-free)
        if len(left) == 1 and all(len(r) >= 1 for r in right):
            if left.isupper() and all((c.islower() or c.isupper() or c == '_' or c == ' ' for r in right for c in r)):
                return "前后文无关文法"

        # Type 1 grammar (Context-sensitive)
        if len(left) >= 1 and all(len(r) >= len(left) for r in right):
            if any(c.isupper() for c in left):
                return "前后文有关文法"

    # Type 0 grammar (Unrestricted)
    return "短语结构文法"


grammar_file = "grammar.txt"
grammar = read_grammar_from_file(grammar_file)
print(grammar)
type = determine_chomsky_type(grammar)
print("该文法是乔姆斯基文法中的", type)

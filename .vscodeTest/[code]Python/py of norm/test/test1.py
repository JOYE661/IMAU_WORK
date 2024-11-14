def read_grammar(file_path):
    grammar = {}
    with open(file_path, 'r') as file:
        for line in file:
            line = line.strip()
            if not line:
                continue  # Ignore empty lines

            if '->' in line:
                left, right = line.split('->', 1)
            elif '::=' in line:
                left, right = line.split('::=', 1)
            else:
                # Custom handling for other cases if needed
                continue

            non_terminal = left.strip()
            productions = [prod.strip() for prod in right.strip().split('|')]
            grammar[non_terminal] = productions

    return grammar

def determine_chomsky_type(grammar):
    for non_terminal, productions in grammar.items():
        # Type 3 grammar (Regular)
        if len(non_terminal) == 1 and all(len(prod) <= 2 for prod in productions):
            if all(len(prod) == 1 and prod.islower() for prod in productions):
                return "正规文法"  # Regular Grammar

        # Type 2 grammar (Context-free)
        if len(non_terminal) == 1 and all(len(prod) >= 1 for prod in productions):
            if non_terminal.isupper() and all(all(c.islower() or c.isupper() or c == '_' or c == ' ' for c in prod) for prod in productions):
                return "前后文无关文法"  # Context-free Grammar

        # Type 1 grammar (Context-sensitive)
        if len(non_terminal) >= 1 and all(len(prod) >= len(non_terminal) for prod in productions):
            if any(c.isupper() for c in non_terminal):
                return "前后文有关文法"  # Context-sensitive Grammar

    # Type 0 grammar (Unrestricted)
    return "短语结构文法"  # Unrestricted Grammar

# Example usage:
grammar_file = "grammar.txt"
grammar = read_grammar(grammar_file)
print(grammar)
grammar_type = determine_chomsky_type(grammar)
print("该文法是乔姆斯基文法中的", grammar_type)
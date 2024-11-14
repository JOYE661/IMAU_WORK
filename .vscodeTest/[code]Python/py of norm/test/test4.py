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

def is_type3_grammar(grammar):
    for non_terminal, productions in grammar.items():
        if len(non_terminal) != 1:
            return False  # 非终结符必须是单个字符

        for prod in productions:
            if len(prod) == 1:
                if not prod.islower():
                    return False  # 右部只能是终结符的单个字符
            elif len(prod) == 2:
                if not (prod[0].isupper() and prod[1].islower() or prod[1].isupper() and prod[0].islower()):
                    return False  # 右部形如Aa
            else:
                return False  # 右部长度最多为2

    return True

def is_type2_grammar(grammar):
    for non_terminal, productions in grammar.items():
        if len(non_terminal) != 1:
            return False  # 非终结符必须是单个字符

        for prod in productions:
            if not all(c.isupper() or c == '@' for c in prod):
                return False  # 右部可以是非终结符或空串@

    return True

def is_type1_grammar(grammar):
    for non_terminal, productions in grammar.items():
        for prod in productions:
            if len(prod) < len(non_terminal):
                return False  # 右部长度必须大于等于左部长度

    return True

def determine_chomsky_type(grammar):
    if is_type3_grammar(grammar):
        return "3型文法: 正则文法"
    elif is_type2_grammar(grammar):
        return "2型文法: 上下文无关文法"
    elif is_type1_grammar(grammar):
        return "1型文法: 上下文相关文法"
    else:
        return "0型文法: 短语结构文法"

# Example usage:
grammar_file = "grammar.txt"
grammar = read_grammar(grammar_file)
print(grammar)
grammar_type = determine_chomsky_type(grammar)
print("该文法是乔姆斯基文法中的", grammar_type)
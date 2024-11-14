def read_grammar(file_path):
    grammar = {}        #通过字典存储提取出的文法字符串
    with open(file_path, 'r') as file:  #可读方式打开文件
        for line in file:       #按行依次扫描
            line = line.strip()
            if not line:
                continue    #文本为空

            if '->' in line:
                left, right = line.split('->', 1)
            elif '::=' in line:
                left, right = line.split('::=', 1)
            else:

                continue

            non_terminal = left.strip()
            productions = [prod.strip() for prod in right.strip().split('|')]
            grammar[non_terminal] = productions

    return grammar

def is_type3_grammar(grammar):#左边只有一个，右边最多包含两个字符（）
    for non_terminal, productions in grammar.items():
        if len(non_terminal) == 1:      #左部分只有一个非终结符
            for prod in productions:
                if len(prod) == 1:      #当右边只有一个字符的时候，该字符必定是终结符
                    if prod.islower():
                        continue
                    else:
                        return False
                elif len(prod) == 2:    #当右边有两个字符的时候，该字符的必定包含一个非终结符（一般大写字母）和一个终结符（一般小写字母）
                    if prod[0].isupper() and prod[1].islower() or prod[1].isupper() and prod[0].islower():
                        continue
                    else:
                        return False
                else:
                    return False
        else:
            return False
    return True

def is_type2_grammar(grammar):
    for non_terminal, productions in grammar.items():
        if len(non_terminal) == 1:
            continue
        else:
            return False
    return True

def is_type1_grammar(grammar):
    for non_terminal, productions in grammar.items():
        for prod in productions:
            if len(prod) < len(non_terminal):
                return False  # 右部字符串长度必须大于等于左部字符串长度

    return True

def determine_chomsky_type(grammar):
    if is_type3_grammar(grammar):
        return "3型文法:正规文法"
    elif is_type2_grammar(grammar):
        return "2型文法:前后文无关文法"
    elif is_type1_grammar(grammar):
        return "1型文法:前后文有关文法"
    else:
        return "0型文法:短语结构文法"

# Example usage:
grammar_file = "grammar.txt"
grammar = read_grammar(grammar_file)
print(grammar)
grammar_type = determine_chomsky_type(grammar)
print("该文法是乔姆斯基文法中的", grammar_type)
def fill_lvl(base_el, parents, lvl, start, end):
    result = []
    for parent in parents:
        base_el.update({"@pid": parent})
        for i in range(start,end):
            base_el.update({"@id": lvl*8 + '-' + lvl*4 + '-' + lvl*4 + '-' + lvl*4 + '-' + lvl*8 + str(i)})
            result.append(base_el.copy())
            if (i + 1) % 500 == 0 and len(parents) > 1:
                start += 500
                break
    return result

def generate_big_model():
    model = {}

    model[''] = [
        {
            "@id": "00000000-0000-0000-0000-000000000000",
            "FED2Tests.Слагаемое1_сalc": 12,
            "FED2Tests.Слагаемое2_сalc": 15,
            "FED2Tests.ПростойУзел_8.Слагаемое_1_узел7": 12,
            "FED2Tests.ПростойУзел_9.Слагаемое_2_узел7": 15,
        }
    ]
    base_el = {
                "@id": "11111111-1111-1111-1111-111111111000",
                "@pid": "00000000-0000-0000-0000-000000000000",
                "Слагаемое_1": 12,
                "Слагаемое_2": 15,
                }
    model['FED2Tests.lvl_one'] = fill_lvl(base_el, ["00000000-0000-0000-0000-000000000000"], '1', 1000, 2500)
    model['FED2Tests.lvl_one.lvl_two'] = fill_lvl(base_el, ["11111111-1111-1111-1111-111111111000", "11111111-1111-1111-1111-111111111001", "11111111-1111-1111-1111-111111111002"], '2', 1000, 2500)
    model['FED2Tests.lvl_one.lvl_two.lvl_three'] = fill_lvl(base_el, ["22222222-2222-2222-2222-222222221000"], '3', 1000, 3000)

    return model


package dev.enjarai.trickster.spell.trick.func;

import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.Pattern;
import dev.enjarai.trickster.spell.SpellContext;
import dev.enjarai.trickster.spell.SpellPart;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.fragment.ListFragment;
import dev.enjarai.trickster.spell.trick.Trick;
import dev.enjarai.trickster.spell.type.Signature;
import dev.enjarai.trickster.spell.blunder.BlunderException;

import java.util.Optional;
import java.util.List;

public class SupplierTrick extends Trick<SupplierTrick> {
    public SupplierTrick() {
        super(Pattern.of(0, 1, 2, 5, 8, 7, 6, 3, 0), Signature.of(ANY, Trick.list(FragmentType.SPELL_PART).optionalOf(), SupplierTrick::run));
    }

    public Fragment run(SpellContext ctx, Fragment glyph, Optional<List<SpellPart>> args ) throws BlunderException {
        var spell = new SpellPart(glyph);
        args.ifPresent(subs -> {spell.subParts = subs;});
        return spell;
    }
}

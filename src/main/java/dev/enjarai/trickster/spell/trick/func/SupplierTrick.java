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

public class SupplierTrick extends Trick<SupplierTrick> {
    public SupplierTrick() {
        super(Pattern.of(0, 1, 2, 5, 8, 7, 6, 3, 0), Signature.of(ANY, FragmentType.LIST.optionalOf(), SupplierTrick::run));
    }

    public Fragment run(SpellContext ctx, Fragment glyph, Optional<ListFragment> args ) throws BlunderException {
        var spell = new SpellPart(glyph);
        args.ifPresent(a -> spell.subParts = a.fragments().stream().map(SpellPart::new).toList());
        return spell;
    }
}

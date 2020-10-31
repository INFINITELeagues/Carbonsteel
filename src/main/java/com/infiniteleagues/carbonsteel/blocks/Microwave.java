package com.infiniteleagues.carbonsteel.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class Microwave extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 2, 16, 9, 14),
            Block.makeCuboidShape(4, 7, 1, 5, 8, 2),
            Block.makeCuboidShape(4, 1, 1, 5, 2, 2),
            Block.makeCuboidShape(4, 1, 0, 5, 8, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(2, 0, 0, 14, 9, 16),
            Block.makeCuboidShape(14, 7, 4, 15, 8, 5),
            Block.makeCuboidShape(14, 1, 4, 15, 2, 5),
            Block.makeCuboidShape(15, 1, 4, 16, 8, 5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 2, 16, 9, 14),
            Block.makeCuboidShape(11, 7, 14, 12, 8, 15),
            Block.makeCuboidShape(11, 1, 14, 12, 2, 15),
            Block.makeCuboidShape(11, 1, 15, 12, 8, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(2, 0, 0, 14, 9, 16),
            Block.makeCuboidShape(1, 7, 11, 2, 8, 12),
            Block.makeCuboidShape(1, 1, 11, 2, 2, 12),
            Block.makeCuboidShape(0, 1, 11, 1, 8, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();




    public Microwave() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5F, 4.0F)
                .sound(SoundType.ANVIL)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE));
    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /**Change the block shadow -- Lower return values = more shadow*/
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.3F;
    }
}